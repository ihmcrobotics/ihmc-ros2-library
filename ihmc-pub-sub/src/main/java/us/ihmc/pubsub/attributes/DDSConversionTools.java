package us.ihmc.pubsub.attributes;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.DurationType;

import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

/**
 * Helper class to convert between different formats inside the DDS layer
 * 
 *  Mostly used for Time
 *  
 * @author jesper
 *
 */
public class DDSConversionTools
{
   /**
    * Convert Time to the XML durationType
    * @param Time
    * @return DurationType
    */
   public static DurationType timeToDurationType(Time time)
   {
      DurationType dt = new DurationType();
      dt.getContent()
        .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_NANOSEC), Long.class, time.getNanoseconds()));
      dt.getContent().add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SEC), Integer.class, time.getSeconds()));

      return dt;
   }

   /**
    * Convert an XML duration type to Time 
    * 
    * @param duration
    * @return Time
    */
   public static Time durationTypeToTime(DurationType duration)
   {
      if(duration == null)
      {
         return null;
      }
      Time time = new Time();
      for (Serializable s : duration.getContent())
      {
         JAXBElement e = (JAXBElement) s;
         switch (e.getName().getLocalPart())
         {
            case FastRTPSDomain.FAST_DDS_NANOSEC:
               time.setNanoseconds((Long) e.getValue());
               break;
            case FastRTPSDomain.FAST_DDS_SEC:
               time.setSeconds((Integer) e.getValue());
               break;
         }
      }
      return time;
   }
   
   /**
    * Create a time element based on time in seconds
    * 
    * @param timeInSeconds
    * @return Time for DDS
    */
   public Time createTime(double timeInSeconds)
   {
      Time time = new Time();
      int seconds = (int) timeInSeconds;
      double remainder = timeInSeconds - seconds;
            
      time.setSeconds((int) timeInSeconds);
      time.setNanoseconds((long)(remainder * 1e9));
      
      return time;

   }
}
