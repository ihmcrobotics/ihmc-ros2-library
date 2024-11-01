#include "IDLElementTest.h"
#include "IDLElementTestPubSubTypes.h"
#include "NestedElement.h"
#include <iomanip>

int main()
{

    test::IDLElementTest msg;
    msg.charTest('3');
    msg.wcharTest(L'Ω');
    msg.octetTest(0xa);
    msg.shortTest(-16);
    msg.ushortTest(15);
    msg.longTest(-58102);
    msg.ulongTest(914);
    msg.longlongTest(-90224141);
    msg.ulonglongTest(582142);
    msg.floatTest(258145.2143f);
    msg.doubleTest(9184289051.1241);
    msg.booleanTest(true);
    msg.colorTest(test::Color::blue);
    msg.nestedElementTest().longTest(518);
    msg.nestedElementTest().stringTest("Nested");
    msg.stringTest("Wolololo");

    for(int i = 0; i < 10; i++)
      {
         msg.longArray()[i] = i * 124;
      }

    for(int a = 0; a < 5; a++)
      {
         for(int b = 0; b < 3; b++)
         {
            msg.nestedArray()[a][b].longTest(a + a * b * 3 + b + 24);
            msg.nestedArray()[a][b].stringTest("arrayDim:" + std::to_string(a) + std::to_string(b));
         }
      }

    for (int i = 0; i < 4; i++)
      {
         msg.stringArray()[i].append("arrayDim:" + std::to_string(i));
      }

    int c = 0;
    for (int s = 1; s < 4; s++)
      {
         for (int w = 0; w < 5; w++)
         {
            int i = s + s * w;
            switch (s)
            {
            case 1:
               msg.charSeqTest().push_back(std::to_string(i).at(0));
               msg.wcharSeqTest().push_back(L'Ω');
               msg.octetSeqTest().push_back(i * 2);
               msg.shortSeqTest().push_back(-2 * i + 1);
               msg.booleanSeqTest().push_back(i % 2 == 0);
            case 2:
               msg.ushortSeqTest().push_back(i + 4);
               msg.longSeqTest().push_back(i * 124 - 98);
               msg.ulongSeqTest().push_back(i * 11561);
               msg.longlongSeqtest().push_back(-2143125l + i * 1251);
            case 3:
               msg.ulonglongSeqTest().push_back(241l + i * 100421410l);
               msg.floatSeqTest().push_back(325.25f * i);
               msg.doubleSeqTest().push_back(15095.921 * i);
               nested::NestedElement nested;
               nested.longTest(i * 541);
               nested.stringTest("dim:" + std::to_string(s) + std::to_string(w));
               msg.nestedSeqTest().push_back(nested);
               msg.stringSeqTest().push_back("sdim:" + std::to_string(s) + std::to_string(w));

            }
         }
      }

    test::IDLElementTestPubSubType type;
    SerializedPayload_t payload(test::IDLElementTest::getMaxCdrSerializedSize());
    type.serialize(&msg,&payload);

    std::cout << "static byte[] cppData = {" << std::setfill('0');
    for(int i = 0; i < payload.length; i++)
    {
        if(i > 0)
        {
            std::cout << ", ";
        }
        std::cout << "(byte)0x" << std::hex  << std::setw(2) << ((int)payload.data[i]);
    }
    std::cout << "};" << std::endl;
}
