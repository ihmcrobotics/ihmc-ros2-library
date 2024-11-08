package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * See:
       * - http://www.ros.org/wiki/rviz/DisplayTypes/Marker
       * - http://www.ros.org/wiki/rviz/Tutorials/Markers%3A%20Basic%20Shapes
       * 
       * for more information on using this message with rviz.
       */
public class Marker extends Packet<Marker> implements Settable<Marker>, EpsilonComparable<Marker>
{
   public static final int ARROW = 0;
   public static final int CUBE = 1;
   public static final int SPHERE = 2;
   public static final int CYLINDER = 3;
   public static final int LINE_STRIP = 4;
   public static final int LINE_LIST = 5;
   public static final int CUBE_LIST = 6;
   public static final int SPHERE_LIST = 7;
   public static final int POINTS = 8;
   public static final int TEXT_VIEW_FACING = 9;
   public static final int MESH_RESOURCE = 10;
   public static final int TRIANGLE_LIST = 11;
   public static final int ADD = 0;
   public static final int MODIFY = 0;
   public static final int DELETE = 2;
   public static final int DELETEALL = 3;
   /**
            * Header for timestamp and frame id.
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * Namespace in which to place the object.
            * Used in conjunction with id to create a unique name for the object.
            */
   public java.lang.StringBuilder ns_;
   /**
            * Object ID used in conjunction with the namespace for manipulating and deleting the object later.
            */
   public int id_;
   /**
            * Type of object.
            */
   public int type_;
   /**
            * Action to take; one of:
            * - 0 add/modify an object
            * - 1 (deprecated)
            * - 2 deletes an object
            * - 3 deletes all objects
            */
   public int action_;
   /**
            * Pose of the object with respect the frame_id specified in the header.
            */
   public us.ihmc.euclid.geometry.Pose3D pose_;
   /**
            * Scale of the object; 1,1,1 means default (usually 1 meter square).
            */
   public us.ihmc.euclid.tuple3D.Vector3D scale_;
   /**
            * Color of the object; in the range: [0.0-1.0]
            */
   public std_msgs.msg.dds.ColorRGBA color_;
   /**
            * How long the object should last before being automatically deleted.
            * 0 indicates forever.
            */
   public builtin_interfaces.msg.dds.Duration lifetime_;
   /**
            * If this marker should be frame-locked, i.e. retransformed into its frame every timestep.
            */
   public boolean frame_locked_;
   /**
            * Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, etc.)
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  points_;
   /**
            * Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, etc.)
            * The number of colors provided must either be 0 or equal to the number of points provided.
            * NOTE: alpha is not yet used
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>  colors_;
   /**
            * Only used for text markers
            */
   public java.lang.StringBuilder text_;
   /**
            * Only used for MESH_RESOURCE markers.
            */
   public java.lang.StringBuilder mesh_resource_;
   public boolean mesh_use_embedded_materials_;

   public Marker()
   {
      header_ = new std_msgs.msg.dds.Header();
      ns_ = new java.lang.StringBuilder(255);
      pose_ = new us.ihmc.euclid.geometry.Pose3D();
      scale_ = new us.ihmc.euclid.tuple3D.Vector3D();
      color_ = new std_msgs.msg.dds.ColorRGBA();
      lifetime_ = new builtin_interfaces.msg.dds.Duration();
      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> (100, new geometry_msgs.msg.dds.PointPubSubType());
      colors_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> (100, new std_msgs.msg.dds.ColorRGBAPubSubType());
      text_ = new java.lang.StringBuilder(255);
      mesh_resource_ = new java.lang.StringBuilder(255);

   }

   public Marker(Marker other)
   {
      this();
      set(other);
   }

   public void set(Marker other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      ns_.setLength(0);
      ns_.append(other.ns_);

      id_ = other.id_;

      type_ = other.type_;

      action_ = other.action_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.pose_, pose_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.scale_, scale_);
      std_msgs.msg.dds.ColorRGBAPubSubType.staticCopy(other.color_, color_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.lifetime_, lifetime_);
      frame_locked_ = other.frame_locked_;

      points_.set(other.points_);
      colors_.set(other.colors_);
      text_.setLength(0);
      text_.append(other.text_);

      mesh_resource_.setLength(0);
      mesh_resource_.append(other.mesh_resource_);

      mesh_use_embedded_materials_ = other.mesh_use_embedded_materials_;

   }


   /**
            * Header for timestamp and frame id.
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * Namespace in which to place the object.
            * Used in conjunction with id to create a unique name for the object.
            */
   public void setNs(java.lang.String ns)
   {
      ns_.setLength(0);
      ns_.append(ns);
   }

   /**
            * Namespace in which to place the object.
            * Used in conjunction with id to create a unique name for the object.
            */
   public java.lang.String getNsAsString()
   {
      return getNs().toString();
   }
   /**
            * Namespace in which to place the object.
            * Used in conjunction with id to create a unique name for the object.
            */
   public java.lang.StringBuilder getNs()
   {
      return ns_;
   }

   /**
            * Object ID used in conjunction with the namespace for manipulating and deleting the object later.
            */
   public void setId(int id)
   {
      id_ = id;
   }
   /**
            * Object ID used in conjunction with the namespace for manipulating and deleting the object later.
            */
   public int getId()
   {
      return id_;
   }

   /**
            * Type of object.
            */
   public void setType(int type)
   {
      type_ = type;
   }
   /**
            * Type of object.
            */
   public int getType()
   {
      return type_;
   }

   /**
            * Action to take; one of:
            * - 0 add/modify an object
            * - 1 (deprecated)
            * - 2 deletes an object
            * - 3 deletes all objects
            */
   public void setAction(int action)
   {
      action_ = action;
   }
   /**
            * Action to take; one of:
            * - 0 add/modify an object
            * - 1 (deprecated)
            * - 2 deletes an object
            * - 3 deletes all objects
            */
   public int getAction()
   {
      return action_;
   }


   /**
            * Pose of the object with respect the frame_id specified in the header.
            */
   public us.ihmc.euclid.geometry.Pose3D getPose()
   {
      return pose_;
   }


   /**
            * Scale of the object; 1,1,1 means default (usually 1 meter square).
            */
   public us.ihmc.euclid.tuple3D.Vector3D getScale()
   {
      return scale_;
   }


   /**
            * Color of the object; in the range: [0.0-1.0]
            */
   public std_msgs.msg.dds.ColorRGBA getColor()
   {
      return color_;
   }


   /**
            * How long the object should last before being automatically deleted.
            * 0 indicates forever.
            */
   public builtin_interfaces.msg.dds.Duration getLifetime()
   {
      return lifetime_;
   }

   /**
            * If this marker should be frame-locked, i.e. retransformed into its frame every timestep.
            */
   public void setFrameLocked(boolean frame_locked)
   {
      frame_locked_ = frame_locked;
   }
   /**
            * If this marker should be frame-locked, i.e. retransformed into its frame every timestep.
            */
   public boolean getFrameLocked()
   {
      return frame_locked_;
   }


   /**
            * Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, etc.)
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  getPoints()
   {
      return points_;
   }


   /**
            * Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, etc.)
            * The number of colors provided must either be 0 or equal to the number of points provided.
            * NOTE: alpha is not yet used
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>  getColors()
   {
      return colors_;
   }

   /**
            * Only used for text markers
            */
   public void setText(java.lang.String text)
   {
      text_.setLength(0);
      text_.append(text);
   }

   /**
            * Only used for text markers
            */
   public java.lang.String getTextAsString()
   {
      return getText().toString();
   }
   /**
            * Only used for text markers
            */
   public java.lang.StringBuilder getText()
   {
      return text_;
   }

   /**
            * Only used for MESH_RESOURCE markers.
            */
   public void setMeshResource(java.lang.String mesh_resource)
   {
      mesh_resource_.setLength(0);
      mesh_resource_.append(mesh_resource);
   }

   /**
            * Only used for MESH_RESOURCE markers.
            */
   public java.lang.String getMeshResourceAsString()
   {
      return getMeshResource().toString();
   }
   /**
            * Only used for MESH_RESOURCE markers.
            */
   public java.lang.StringBuilder getMeshResource()
   {
      return mesh_resource_;
   }

   public void setMeshUseEmbeddedMaterials(boolean mesh_use_embedded_materials)
   {
      mesh_use_embedded_materials_ = mesh_use_embedded_materials;
   }
   public boolean getMeshUseEmbeddedMaterials()
   {
      return mesh_use_embedded_materials_;
   }


   public static Supplier<MarkerPubSubType> getPubSubType()
   {
      return MarkerPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MarkerPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Marker other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.ns_, other.ns_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.action_, other.action_, epsilon)) return false;

      if (!this.pose_.epsilonEquals(other.pose_, epsilon)) return false;
      if (!this.scale_.epsilonEquals(other.scale_, epsilon)) return false;
      if (!this.color_.epsilonEquals(other.color_, epsilon)) return false;
      if (!this.lifetime_.epsilonEquals(other.lifetime_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.frame_locked_, other.frame_locked_, epsilon)) return false;

      if (this.points_.size() != other.points_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {  if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon)) return false; }
      }

      if (this.colors_.size() != other.colors_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.colors_.size(); i++)
         {  if (!this.colors_.get(i).epsilonEquals(other.colors_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.text_, other.text_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.mesh_resource_, other.mesh_resource_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.mesh_use_embedded_materials_, other.mesh_use_embedded_materials_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Marker)) return false;

      Marker otherMyClass = (Marker) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.ns_, otherMyClass.ns_)) return false;

      if(this.id_ != otherMyClass.id_) return false;

      if(this.type_ != otherMyClass.type_) return false;

      if(this.action_ != otherMyClass.action_) return false;

      if (!this.pose_.equals(otherMyClass.pose_)) return false;
      if (!this.scale_.equals(otherMyClass.scale_)) return false;
      if (!this.color_.equals(otherMyClass.color_)) return false;
      if (!this.lifetime_.equals(otherMyClass.lifetime_)) return false;
      if(this.frame_locked_ != otherMyClass.frame_locked_) return false;

      if (!this.points_.equals(otherMyClass.points_)) return false;
      if (!this.colors_.equals(otherMyClass.colors_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.text_, otherMyClass.text_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.mesh_resource_, otherMyClass.mesh_resource_)) return false;

      if(this.mesh_use_embedded_materials_ != otherMyClass.mesh_use_embedded_materials_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Marker {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("ns=");
      builder.append(this.ns_);      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("action=");
      builder.append(this.action_);      builder.append(", ");
      builder.append("pose=");
      builder.append(this.pose_);      builder.append(", ");
      builder.append("scale=");
      builder.append(this.scale_);      builder.append(", ");
      builder.append("color=");
      builder.append(this.color_);      builder.append(", ");
      builder.append("lifetime=");
      builder.append(this.lifetime_);      builder.append(", ");
      builder.append("frame_locked=");
      builder.append(this.frame_locked_);      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);      builder.append(", ");
      builder.append("colors=");
      builder.append(this.colors_);      builder.append(", ");
      builder.append("text=");
      builder.append(this.text_);      builder.append(", ");
      builder.append("mesh_resource=");
      builder.append(this.mesh_resource_);      builder.append(", ");
      builder.append("mesh_use_embedded_materials=");
      builder.append(this.mesh_use_embedded_materials_);
      builder.append("}");
      return builder.toString();
   }
}
