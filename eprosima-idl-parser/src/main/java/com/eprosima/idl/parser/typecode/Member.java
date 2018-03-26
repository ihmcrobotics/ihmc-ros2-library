// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.eprosima.idl.parser.typecode;

import com.eprosima.idl.context.Context;
import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.Notebook;
import org.apache.commons.lang3.StringUtils;
import us.ihmc.commons.FormattingTools;

import java.util.HashMap;
import java.util.Map;

public class Member implements Notebook
{
    public Member()
    {
        m_annotations = new HashMap<String, Annotation>();
    }
    
    public Member(TypeCode typecode, String name, String comments)
    {
        m_typecode = typecode;
        m_name = name;
        m_annotations = new HashMap<String, Annotation>();

        m_comments = comments;
    }

    public String getComments()
    {
        return m_comments;
    }
    
    public String getName()
    {
        return m_name;
    }

    public String getJavaName()
    {
        if (m_name != null)
        {
            // @dcalvert: Fix Java method naming from getSome_type() to getSomeType()
            if (m_name.contains("_"))
            {
                return FormattingTools.underscoredToCamelCase(m_name, true);
            }
            else
            {
                return StringUtils.capitalize(m_name);
            }
        }
    	return null;
    }

    /*
     * @brief This function is used with RTI DDS types because array names contains [].
     */
    
    public TypeCode getTypecode()
    {
        return m_typecode;
    }
    
    public void setName(String name)
    {
        m_name = name;
    }
    
    public void setTypecode(TypeCode typecode)
    {
         m_typecode = typecode;
    }

    @Override
    public void addAnnotation(Context ctx, Annotation annotation)
    {
        if(annotation != null)
        {
            if (annotation.getName().equals("defaultValue"))
            {
                String parsedValue = annotation.getValue("value");

                parsedValue = parsedValue.replaceAll("null", "");

                if (parsedValue.equals("True") || parsedValue.equals("False"))
                {
                    parsedValue = parsedValue.toLowerCase();
                }
                else if (getTypecode().getJavaTypename().equals("byte"))
                {
                    parsedValue = "(byte) " + parsedValue;
                }
                else if (getTypecode().getJavaTypename().equals("double") && parsedValue.equals("inf"))
                {
                    parsedValue = "Double.POSITIVE_INFINITY";
                }

                m_defaultValue = parsedValue;
            }
            m_annotations.put(annotation.getName(), annotation);
        }
    }

    @Override
    public Map<String, Annotation> getAnnotations()
    {
        return m_annotations;
    }

    public boolean getHasDefaultValue()
    {
        return m_defaultValue != null;
    }

    public String getDefaultValue()
    {
        return m_defaultValue;
    }
    
    private String m_name = null;
    
    private TypeCode m_typecode = null;

    private HashMap<String, Annotation> m_annotations = null;

    private String m_comments;

    private String m_defaultValue = null;
}
