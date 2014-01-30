#include <stdio.h>

typedef int Elem;

typedef struct Kolekcja 
{ 
    Elem k;
    Kolekcja * next;
} Kolekcja;

Kolekcja ** first;

void zbior(Kolekcja ** k)
{
  first = k;
}

int main() {
  zbior(new Kolekcja);

  return 0;
}