package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Used to send raw mesh files.
       */
public class MeshFile extends Packet<MeshFile> implements Settable<MeshFile>, EpsilonComparable<MeshFile>
{
   /**
            * The filename is used for both debug purposes and to provide a file extension
            * for whatever parser is used.
            */
   public java.lang.StringBuilder filename_;
   /**
            * This stores the raw text of the mesh file.
            */
   public us.ihmc.idl.IDLSequence.Byte  data_;

   public MeshFile()
   {
      filename_ = new java.lang.StringBuilder(255);
      data_ = new us.ihmc.idl.IDLSequence.Byte (100, "type_9");

   }

   public MeshFile(MeshFile other)
   {
      this();
      set(other);
   }

   public void set(MeshFile other)
   {
      filename_.setLength(0);
      filename_.append(other.filename_);

      data_.set(other.data_);
   }

   /**
            * The filename is used for both debug purposes and to provide a file extension
            * for whatever parser is used.
            */
   public void setFilename(java.lang.String filename)
   {
      filename_.setLength(0);
      filename_.append(filename);
   }

   /**
            * The filename is used for both debug purposes and to provide a file extension
            * for whatever parser is used.
            */
   public java.lang.String getFilenameAsString()
   {
      return getFilename().toString();
   }
   /**
            * The filename is used for both debug purposes and to provide a file extension
            * for whatever parser is used.
            */
   public java.lang.StringBuilder getFilename()
   {
      return filename_;
   }


   /**
            * This stores the raw text of the mesh file.
            */
   public us.ihmc.idl.IDLSequence.Byte  getData()
   {
      return data_;
   }


   public static Supplier<MeshFilePubSubType> getPubSubType()
   {
      return MeshFilePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MeshFilePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MeshFile other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.filename_, other.filename_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MeshFile)) return false;

      MeshFile otherMyClass = (MeshFile) other;

      if (!us.ihmc.idl.IDLTools.equals(this.filename_, otherMyClass.filename_)) return false;

      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MeshFile {");
      builder.append("filename=");
      builder.append(this.filename_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}
