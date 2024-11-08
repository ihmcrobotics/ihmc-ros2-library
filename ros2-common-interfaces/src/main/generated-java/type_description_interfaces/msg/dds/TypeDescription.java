package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents a complete type description, including the type itself as well as the types it references.
       */
public class TypeDescription extends Packet<TypeDescription> implements Settable<TypeDescription>, EpsilonComparable<TypeDescription>
{
   /**
            * Description of the type.
            */
   public type_description_interfaces.msg.dds.IndividualTypeDescription type_description_;
   /**
            * Descriptions of all referenced types, recursively.
            */
   public us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.IndividualTypeDescription>  referenced_type_descriptions_;

   public TypeDescription()
   {
      type_description_ = new type_description_interfaces.msg.dds.IndividualTypeDescription();
      referenced_type_descriptions_ = new us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.IndividualTypeDescription> (100, new type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType());

   }

   public TypeDescription(TypeDescription other)
   {
      this();
      set(other);
   }

   public void set(TypeDescription other)
   {
      type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.staticCopy(other.type_description_, type_description_);
      referenced_type_descriptions_.set(other.referenced_type_descriptions_);
   }


   /**
            * Description of the type.
            */
   public type_description_interfaces.msg.dds.IndividualTypeDescription getTypeDescription()
   {
      return type_description_;
   }


   /**
            * Descriptions of all referenced types, recursively.
            */
   public us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.IndividualTypeDescription>  getReferencedTypeDescriptions()
   {
      return referenced_type_descriptions_;
   }


   public static Supplier<TypeDescriptionPubSubType> getPubSubType()
   {
      return TypeDescriptionPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TypeDescriptionPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TypeDescription other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.type_description_.epsilonEquals(other.type_description_, epsilon)) return false;
      if (this.referenced_type_descriptions_.size() != other.referenced_type_descriptions_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.referenced_type_descriptions_.size(); i++)
         {  if (!this.referenced_type_descriptions_.get(i).epsilonEquals(other.referenced_type_descriptions_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TypeDescription)) return false;

      TypeDescription otherMyClass = (TypeDescription) other;

      if (!this.type_description_.equals(otherMyClass.type_description_)) return false;
      if (!this.referenced_type_descriptions_.equals(otherMyClass.referenced_type_descriptions_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TypeDescription {");
      builder.append("type_description=");
      builder.append(this.type_description_);      builder.append(", ");
      builder.append("referenced_type_descriptions=");
      builder.append(this.referenced_type_descriptions_);
      builder.append("}");
      return builder.toString();
   }
}
