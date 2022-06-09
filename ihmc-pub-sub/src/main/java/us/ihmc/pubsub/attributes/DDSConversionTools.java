package us.ihmc.pubsub.attributes;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.DurationType;

import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

public class DDSConversionTools
{
   public static DurationType timeToDurationType(Time time)
   {
      DurationType dt = new DurationType();
      dt.getContent()
        .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_NANOSEC), Long.class, time.getNanoseconds()));
      dt.getContent().add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SEC), Integer.class, time.getSeconds()));

      return dt;
   }

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
}
