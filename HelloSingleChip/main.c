#include "reg52.h"
typedef unsigned char u8;
typedef unsigned int u16;
sbit beep=P1^5;

void delay(u16 i)   //Îó²î 0us
{
   while(i--);
}
void main()
{  
	while(1){
		beep=~beep;
		delay(500);
	}
}