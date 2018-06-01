/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.idl.generator;

import org.anarres.cpp.LexerException;
import org.anarres.cpp.Preprocessor;
import org.anarres.cpp.Token;

import java.io.IOException;

/**
 * Helper class the replace tokens to the format IDLParser expects.
 *
 * Replaces #line with #.
 *
 * @author Jesper Smith
 */
public class PreprocessorFilter extends Preprocessor
{
   @Override
   public Token token() throws IOException, LexerException
   {
      Token next = super.token();
      if (next != null && next.getType() == Token.P_LINE)
      {
         next = new Token(Token.P_LINE, next.getLine(), next.getColumn(), next.getText().replaceFirst("#line", "#"));
      }

      return next;
   }
}
