package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents the original source of a ROS 2 interface definition.
       */
public class TypeSource extends Packet<TypeSource> implements Settable<TypeSource>, EpsilonComparable<TypeSource>
{
   /**
            * ROS interface type name, in PACKAGE/NAMESPACE/TYPENAME format.
            */
   public java.lang.StringBuilder type_name_;
   /**
            * The type of the original source file, typically matching the file extension.
            * Well-known encodings: "idl", "msg", "srv", "action", "dynamic", "implicit".
            * "dynamic" specifies a type created programmatically by a user, thus having no source.
            * "implicit" specifies a type created automatically as a subtype of a
            * complex type (service or action) - such as the request message for a service.
            * Implicit types will have no contents, the full source will be available on the parent srv/action.
            */
   public java.lang.StringBuilder encoding_;
   /**
            * Dumped contents of the interface definition source file.
            * If `encoding` is "dynamic" or "implicit", this field will be empty.
            */
   public java.lang.StringBuilder raw_file_contents_;

   public TypeSource()
   {
      type_name_ = new java.lang.StringBuilder(255);
      encoding_ = new java.lang.StringBuilder(255);
      raw_file_contents_ = new java.lang.StringBuilder(255);
   }

   public TypeSource(TypeSource other)
   {
      this();
      set(other);
   }

   public void set(TypeSource other)
   {
      type_name_.setLength(0);
      type_name_.append(other.type_name_);

      encoding_.setLength(0);
      encoding_.append(other.encoding_);

      raw_file_contents_.setLength(0);
      raw_file_contents_.append(other.raw_file_contents_);

   }

   /**
            * ROS interface type name, in PACKAGE/NAMESPACE/TYPENAME format.
            */
   public void setTypeName(java.lang.String type_name)
   {
      type_name_.setLength(0);
      type_name_.append(type_name);
   }

   /**
            * ROS interface type name, in PACKAGE/NAMESPACE/TYPENAME format.
            */
   public java.lang.String getTypeNameAsString()
   {
      return getTypeName().toString();
   }
   /**
            * ROS interface type name, in PACKAGE/NAMESPACE/TYPENAME format.
            */
   public java.lang.StringBuilder getTypeName()
   {
      return type_name_;
   }

   /**
            * The type of the original source file, typically matching the file extension.
            * Well-known encodings: "idl", "msg", "srv", "action", "dynamic", "implicit".
            * "dynamic" specifies a type created programmatically by a user, thus having no source.
            * "implicit" specifies a type created automatically as a subtype of a
            * complex type (service or action) - such as the request message for a service.
            * Implicit types will have no contents, the full source will be available on the parent srv/action.
            */
   public void setEncoding(java.lang.String encoding)
   {
      encoding_.setLength(0);
      encoding_.append(encoding);
   }

   /**
            * The type of the original source file, typically matching the file extension.
            * Well-known encodings: "idl", "msg", "srv", "action", "dynamic", "implicit".
            * "dynamic" specifies a type created programmatically by a user, thus having no source.
            * "implicit" specifies a type created automatically as a subtype of a
            * complex type (service or action) - such as the request message for a service.
            * Implicit types will have no contents, the full source will be available on the parent srv/action.
            */
   public java.lang.String getEncodingAsString()
   {
      return getEncoding().toString();
   }
   /**
            * The type of the original source file, typically matching the file extension.
            * Well-known encodings: "idl", "msg", "srv", "action", "dynamic", "implicit".
            * "dynamic" specifies a type created programmatically by a user, thus having no source.
            * "implicit" specifies a type created automatically as a subtype of a
            * complex type (service or action) - such as the request message for a service.
            * Implicit types will have no contents, the full source will be available on the parent srv/action.
            */
   public java.lang.StringBuilder getEncoding()
   {
      return encoding_;
   }

   /**
            * Dumped contents of the interface definition source file.
            * If `encoding` is "dynamic" or "implicit", this field will be empty.
            */
   public void setRawFileContents(java.lang.String raw_file_contents)
   {
      raw_file_contents_.setLength(0);
      raw_file_contents_.append(raw_file_contents);
   }

   /**
            * Dumped contents of the interface definition source file.
            * If `encoding` is "dynamic" or "implicit", this field will be empty.
            */
   public java.lang.String getRawFileContentsAsString()
   {
      return getRawFileContents().toString();
   }
   /**
            * Dumped contents of the interface definition source file.
            * If `encoding` is "dynamic" or "implicit", this field will be empty.
            */
   public java.lang.StringBuilder getRawFileContents()
   {
      return raw_file_contents_;
   }


   public static Supplier<TypeSourcePubSubType> getPubSubType()
   {
      return TypeSourcePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TypeSourcePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TypeSource other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.type_name_, other.type_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.encoding_, other.encoding_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.raw_file_contents_, other.raw_file_contents_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TypeSource)) return false;

      TypeSource otherMyClass = (TypeSource) other;

      if (!us.ihmc.idl.IDLTools.equals(this.type_name_, otherMyClass.type_name_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.encoding_, otherMyClass.encoding_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.raw_file_contents_, otherMyClass.raw_file_contents_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TypeSource {");
      builder.append("type_name=");
      builder.append(this.type_name_);      builder.append(", ");
      builder.append("encoding=");
      builder.append(this.encoding_);      builder.append(", ");
      builder.append("raw_file_contents=");
      builder.append(this.raw_file_contents_);
      builder.append("}");
      return builder.toString();
   }
}
