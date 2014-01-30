#include "zad3.h"

int main() {
  Zespolone a,b,c;

  a.real = 12;
  a.imagin = 50;
  a.mianownik_dzielenia = 1;

  b.real = 20;
  b.imagin = 23;
  a.mianownik_dzielenia = 1;

  c.real = 0;
  c.imagin = 0;
  a.mianownik_dzielenia = 1;

  printf("Pierwsza liczba: %f + %fi\n", a.real, a.imagin);
  printf("Druga liczba: %f + %fi\n", b.real, b.imagin);
  printf("Trzecia liczba: %f + %fi\n", c.real, c.imagin);
  printf("\n\nDodawanie:\n\n");

  c = dodawanie(&a, &b);

  printf("Pierwsza liczba: %f + %fi\n", a.real, a.imagin);
  printf("Druga liczba: %f + %fi\n", b.real, b.imagin);
  printf("Trzecia liczba: %f + %fi\n", c.real, c.imagin);
  printf("\n\nOdejmowanie:\n\n");

  odejmowanie2(&a, &b);

  printf("Pierwsza liczba: %f + %fi\n", a.real, a.imagin);
  printf("Druga liczba: %f + %fi\n", b.real, b.imagin);
  printf("Trzecia liczba: %f + %fi\n", c.real, c.imagin);
  printf("\n\nDzielenie:\n\n");

  c = dzielenie(&a, &b);
  printf("Pierwsza liczba: %f + %fi i mianownik: %f\n", a.real, a.imagin, a.mianownik_dzielenia);
  printf("Druga liczba: %f + %fi i mianownik: %f\n", b.real, b.imagin, b.mianownik_dzielenia);
  printf("Trzecia liczba: %f + %fi i mianownik: %f\n", c.real, c.imagin, c.mianownik_dzielenia);


  return 0;
}