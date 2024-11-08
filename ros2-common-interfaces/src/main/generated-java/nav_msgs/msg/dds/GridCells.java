package nav_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * An array of cells in a 2D grid
       */
public class GridCells extends Packet<GridCells> implements Settable<GridCells>, EpsilonComparable<GridCells>
{
   public std_msgs.msg.dds.Header header_;
   /**
            * Width of each cell
            */
   public float cell_width_;
   /**
            * Height of each cell
            */
   public float cell_height_;
   /**
            * Each cell is represented by the Point at the center of the cell
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  cells_;

   public GridCells()
   {
      header_ = new std_msgs.msg.dds.Header();
      cells_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> (100, new geometry_msgs.msg.dds.PointPubSubType());

   }

   public GridCells(GridCells other)
   {
      this();
      set(other);
   }

   public void set(GridCells other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      cell_width_ = other.cell_width_;

      cell_height_ = other.cell_height_;

      cells_.set(other.cells_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * Width of each cell
            */
   public void setCellWidth(float cell_width)
   {
      cell_width_ = cell_width;
   }
   /**
            * Width of each cell
            */
   public float getCellWidth()
   {
      return cell_width_;
   }

   /**
            * Height of each cell
            */
   public void setCellHeight(float cell_height)
   {
      cell_height_ = cell_height;
   }
   /**
            * Height of each cell
            */
   public float getCellHeight()
   {
      return cell_height_;
   }


   /**
            * Each cell is represented by the Point at the center of the cell
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  getCells()
   {
      return cells_;
   }


   public static Supplier<GridCellsPubSubType> getPubSubType()
   {
      return GridCellsPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return GridCellsPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(GridCells other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.cell_width_, other.cell_width_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.cell_height_, other.cell_height_, epsilon)) return false;

      if (this.cells_.size() != other.cells_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.cells_.size(); i++)
         {  if (!this.cells_.get(i).epsilonEquals(other.cells_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof GridCells)) return false;

      GridCells otherMyClass = (GridCells) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if(this.cell_width_ != otherMyClass.cell_width_) return false;

      if(this.cell_height_ != otherMyClass.cell_height_) return false;

      if (!this.cells_.equals(otherMyClass.cells_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GridCells {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("cell_width=");
      builder.append(this.cell_width_);      builder.append(", ");
      builder.append("cell_height=");
      builder.append(this.cell_height_);      builder.append(", ");
      builder.append("cells=");
      builder.append(this.cells_);
      builder.append("}");
      return builder.toString();
   }
}
