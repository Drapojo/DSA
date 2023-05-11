#include<stdio.h>
#include<string.h>
int main()
{
	char s[256];
	gets(s);
	int max=0,i=0,j=0;
	int chuoi[256]={0};
	for(;i<strlen(s);)
		if(chuoi[s[i]]==0)
		{
			chuoi[s[i]]++;
			i++;
			if((i-j)>max) max=i-j;
		}
		else
		{
			chuoi[s[j]]--;
			j++;
		}
	printf("%d",max);
}
