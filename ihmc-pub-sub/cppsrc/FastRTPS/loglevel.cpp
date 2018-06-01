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
#include "loglevel.h"

#include <fastrtps/log/Log.h>

using namespace eprosima::fastrtps;
using namespace us::ihmc::rtps::impl::fastRTPS;
void LogLevel::setLogLevel(int level)
{
    switch(level)
    {
    case 0:
        eprosima::fastrtps::Log::SetVerbosity(Log::Error);
        break;
    case 1:
        eprosima::fastrtps::Log::SetVerbosity(Log::Warning);
        break;
    case 2:
        eprosima::fastrtps::Log::SetVerbosity(Log::Info);
        break;
    }
}
