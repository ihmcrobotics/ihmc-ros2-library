/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef SAMPLEINFOMARSHALLER_H
#define SAMPLEINFOMARSHALLER_H

#include <fastrtps/rtps/common/Types.h>
#include <cstring>


namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{
    class SampleInfoMarshaller
    {
    public:

        int16_t encapsulation;
        int32_t dataLength;

        int32_t changeKind;
        int32_t ownershipStrength;

        int32_t time_seconds;
        int64_t time_fraction;

        unsigned char instanceHandle_value[16];

        int64_t sampleIdentity_GuidHigh;
        int64_t sampleIdentity_GuidLow;
        int32_t sampleIdentity_sequenceNumberHigh;
        int64_t sampleIdentity_sequenceNumberLow;

        int64_t relatedSampleIdentity_GuidHigh;
        int64_t relatedSampleIdentity_GuidLow;
        int32_t relatedSampleIdentity_sequenceNumberHigh;
        int64_t relatedSampleIdentity_sequenceNumberLow;

        void getInstanceHandleValue(unsigned char* dest)
        {
            memcpy(dest, instanceHandle_value, 16);
        }

    };

}}}}}
#endif // SAMPLEINFOMARSHALLER_H

