#include<stdio.h>
#include<stdlib.h>
int Menu()
{
	int choice;
	printf("1. Input size of list\n");
	printf("2. Input number in the list\n");
	printf("3. Print the list\n");
	printf("4. Next list\n");
	printf("5. Previous list\n");
	printf("0. to exit\n");
	printf("Your choice: ");
	scanf("%d",&choice);
	return choice;
}
void NumberOfList(int *numberOfList)
{
	printf("Input number of list: ");
	scanf("%d",numberOfList);
}
void InputSize(int size[256],int listNumber)
{
	scanf("%d",&size[listNumber]);
}
void InputNumber(int list[][256],int size[256],int listNumber)
{
	int i;
	for(i=1;i<=size[listNumber];i++)
		scanf("%d",&list[listNumber][i]);		
}
void Output(int list[][256],int size[256],int listNumber)
{
	int i;
	for(i=1;i<=size[listNumber];i++)
		printf("[%d]\n",list[listNumber][i]);
}
int ChangeList(int listNumber,int numberOfList)
{
	if(listNumber>numberOfList||listNumber<1)
		return 1;
	
}
int main()
{
	int list[256][256],size[256],choice,listNumber=1,numberOfList;
	NumberOfList(&numberOfList);
	do
	{
		printf("List %d\n",listNumber);
		choice=Menu();
		switch(choice)
		{
			case 1:
				{
					InputSize(size,listNumber);
					break;
				}
			case 2:
				{
					InputNumber(list,size,listNumber);
					break;
				}
			case 3:
				{
					Output(list,size,listNumber);
					break;
				}
			case 4:
				{
					listNumber++;
					if(ChangeList(listNumber,numberOfList)==1) listNumber=numberOfList;
					break;
				}
			case 5:
				{
					listNumber--;
					if(ChangeList(listNumber,numberOfList)==1) listNumber=1;
					break;
				}
		}	
	}while(choice!=0);	
}
