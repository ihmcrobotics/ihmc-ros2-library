package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class FooHandshake extends Packet<FooHandshake> implements Settable<FooHandshake>, EpsilonComparable<FooHandshake>
{
   public double dt_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoRegistryDefinition>  registries_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoVariableDefinition>  variables_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooJointDefinition>  joints_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage>  graphicObjects_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage>  artifacts_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooEnumType>  enumTypes_;
   public us.ihmc.idl.generated.test.FooSummary summary_;

   public FooHandshake()
   {
      registries_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoRegistryDefinition> (1024, new us.ihmc.idl.generated.test.FooYoRegistryDefinitionPubSubType());
      variables_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoVariableDefinition> (32767, new us.ihmc.idl.generated.test.FooYoVariableDefinitionPubSubType());
      joints_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooJointDefinition> (128, new us.ihmc.idl.generated.test.FooJointDefinitionPubSubType());
      graphicObjects_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage> (2048, new us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType());
      artifacts_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage> (2048, new us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType());
      enumTypes_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooEnumType> (1024, new us.ihmc.idl.generated.test.FooEnumTypePubSubType());
      summary_ = new us.ihmc.idl.generated.test.FooSummary();

   }

   public FooHandshake(FooHandshake other)
   {
      this();
      set(other);
   }

   public void set(FooHandshake other)
   {
      dt_ = other.dt_;

      registries_.set(other.registries_);
      variables_.set(other.variables_);
      joints_.set(other.joints_);
      graphicObjects_.set(other.graphicObjects_);
      artifacts_.set(other.artifacts_);
      enumTypes_.set(other.enumTypes_);
      us.ihmc.idl.generated.test.FooSummaryPubSubType.staticCopy(other.summary_, summary_);
   }

   public void setDt(double dt)
   {
      dt_ = dt;
   }
   public double getDt()
   {
      return dt_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoRegistryDefinition>  getRegistries()
   {
      return registries_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooYoVariableDefinition>  getVariables()
   {
      return variables_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooJointDefinition>  getJoints()
   {
      return joints_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage>  getGraphicObjects()
   {
      return graphicObjects_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooGraphicObjectMessage>  getArtifacts()
   {
      return artifacts_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.FooEnumType>  getEnumTypes()
   {
      return enumTypes_;
   }


   public us.ihmc.idl.generated.test.FooSummary getSummary()
   {
      return summary_;
   }


   public static Supplier<FooHandshakePubSubType> getPubSubType()
   {
      return FooHandshakePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return FooHandshakePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(FooHandshake other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.dt_, other.dt_, epsilon)) return false;

      if (this.registries_.size() != other.registries_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.registries_.size(); i++)
         {  if (!this.registries_.get(i).epsilonEquals(other.registries_.get(i), epsilon)) return false; }
      }

      if (this.variables_.size() != other.variables_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.variables_.size(); i++)
         {  if (!this.variables_.get(i).epsilonEquals(other.variables_.get(i), epsilon)) return false; }
      }

      if (this.joints_.size() != other.joints_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.joints_.size(); i++)
         {  if (!this.joints_.get(i).epsilonEquals(other.joints_.get(i), epsilon)) return false; }
      }

      if (this.graphicObjects_.size() != other.graphicObjects_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.graphicObjects_.size(); i++)
         {  if (!this.graphicObjects_.get(i).epsilonEquals(other.graphicObjects_.get(i), epsilon)) return false; }
      }

      if (this.artifacts_.size() != other.artifacts_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.artifacts_.size(); i++)
         {  if (!this.artifacts_.get(i).epsilonEquals(other.artifacts_.get(i), epsilon)) return false; }
      }

      if (this.enumTypes_.size() != other.enumTypes_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.enumTypes_.size(); i++)
         {  if (!this.enumTypes_.get(i).epsilonEquals(other.enumTypes_.get(i), epsilon)) return false; }
      }

      if (!this.summary_.epsilonEquals(other.summary_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof FooHandshake)) return false;

      FooHandshake otherMyClass = (FooHandshake) other;

      if(this.dt_ != otherMyClass.dt_) return false;

      if (!this.registries_.equals(otherMyClass.registries_)) return false;
      if (!this.variables_.equals(otherMyClass.variables_)) return false;
      if (!this.joints_.equals(otherMyClass.joints_)) return false;
      if (!this.graphicObjects_.equals(otherMyClass.graphicObjects_)) return false;
      if (!this.artifacts_.equals(otherMyClass.artifacts_)) return false;
      if (!this.enumTypes_.equals(otherMyClass.enumTypes_)) return false;
      if (!this.summary_.equals(otherMyClass.summary_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("FooHandshake {");
      builder.append("dt=");
      builder.append(this.dt_);      builder.append(", ");
      builder.append("registries=");
      builder.append(this.registries_);      builder.append(", ");
      builder.append("variables=");
      builder.append(this.variables_);      builder.append(", ");
      builder.append("joints=");
      builder.append(this.joints_);      builder.append(", ");
      builder.append("graphicObjects=");
      builder.append(this.graphicObjects_);      builder.append(", ");
      builder.append("artifacts=");
      builder.append(this.artifacts_);      builder.append(", ");
      builder.append("enumTypes=");
      builder.append(this.enumTypes_);      builder.append(", ");
      builder.append("summary=");
      builder.append(this.summary_);
      builder.append("}");
      return builder.toString();
   }
}
