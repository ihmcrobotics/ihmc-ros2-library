package us.ihmc.ros2;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;

import java.net.InetAddress;

/**
 * An implementation of a ROS2 compatible node. This node can be used to create ROS2
 * compatible publishers and subscribers.
 *
 * @author Jesper Smith
 */
public class ROS2Node extends ROS2NodeBasics
{
   /**
    * Create a new ROS 2 node with the default namespace.
    *
    * @param pubSubImplementation The implementation to use.
    * @param name                 Name of the ROS 2 node
    * @param domainId             Desired ROS domain ID
    * @param addressRestriction   Restrict network traffic to the given addresses. When provided, it
    *                             should describe one of the addresses of the computer hosting this node.
    *                             Optional.
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name, int domainId, InetAddress... addressRestriction)
   {
      this(DomainFactory.getDomain(pubSubImplementation), name, ROS2NodeBasics.DEFAULT_NAMESPACE, domainId, addressRestriction);
   }

   /**
    * Create a new ROS 2 node.
    *
    * @param domain DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name   Name of the ROS 2 node
    */
   public ROS2Node(Domain domain, String name)
   {
      this(domain, name, "", ROS2NodeInterface.domainFromEnvironment(), ROS2NodeInterface.useSHMFromEnvironment());
   }
   
   /**
    * Create a new ROS 2 node.
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, InetAddress... addressRestriction)
   {
      this(domain, name, namespace, domainId, ROS2NodeInterface.useSHMFromEnvironment(), addressRestriction);
   }
   
   /**
    * Create a new ROS 2 node.
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param useSharedMemory    Enable shared memory transport
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, boolean useSharedMemory, InetAddress... addressRestriction)
   {
      this(domain, name, namespace, ROS2NodeInterface.createParticipantAttributes(domainId, useSharedMemory, addressRestriction));
   }

   /**
    * Create a new ROS 2 node.
    *
    * @param domain     DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name       Name of the ROS 2 node
    * @param namespace  Namespace of the ROS 2 node
    * @param attributes ParticipantAttributes for the domain
    */
   public ROS2Node(Domain domain, String name, String namespace, ParticipantAttributes attributes)
   {
      super(domain, name, namespace, attributes);
   }
}
