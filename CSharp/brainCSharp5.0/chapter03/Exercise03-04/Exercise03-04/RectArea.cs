using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercise03_04
{
    class RectArea
    {
        static void Main(string[] args)
        {
            Console.WriteLine("사각형의 너비를 입력하세요.");
            string width = Console.ReadLine();

            Console.WriteLine("사각형의 높이를 입력하세요.");
            string height = Console.ReadLine();

            int w = Convert.ToInt32(width);
            int h = Convert.ToInt32(height);

            Console.WriteLine("사각형의 면적은 {0} 입니다.", w * h);
        }
    }
}
