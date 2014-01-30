#ifndef ZAD3
#define ZAD3
#include <stdio.h>
void wiki (void) {printf("pl.Wikibooks\n");}

typedef struct Zespolone {
  float real;
  float imagin;
  float mianownik_dzielenia;
} Zespolone;


Zespolone dodawanie(Zespolone *a, Zespolone *b);
void dodawanie2(Zespolone *a, Zespolone *b);
Zespolone odejmowanie(Zespolone *a, Zespolone *b);
void odejmowanie2(Zespolone *a, Zespolone *b);
Zespolone mnozenie(Zespolone *a, Zespolone *b);
void mnozenie2(Zespolone *a, Zespolone *b);
Zespolone dzielenie(Zespolone *a, Zespolone *b);
void dzielenie2(Zespolone *a, Zespolone *b);

Zespolone dodawanie(Zespolone *a, Zespolone *b) {
  Zespolone temp;

  temp.real = (*a).real + (*b).real;
  temp.imagin = (*a).imagin + (*b).imagin;
  return temp;
}

void dodawanie2(Zespolone *a, Zespolone *b) {
  (*b).real = (*a).real + (*b).real;
  (*b).imagin = (*a).imagin + (*b).imagin;
}

Zespolone odejmowanie(Zespolone *a, Zespolone *b) {
  Zespolone temp;

  temp.real = (*a).real - (*b).real;
  temp.imagin = (*a).imagin - (*b).imagin;
  return temp;
}

void odejmowanie2(Zespolone *a, Zespolone *b) {
  (*b).real = (*a).real - (*b).real;
  (*b).imagin = (*a).imagin - (*b).imagin;
}

Zespolone mnozenie(Zespolone *a, Zespolone *b) {
  Zespolone temp;

  temp.real = (*a).real * (*b).real - (*a).imagin - (*b).imagin;
  temp.imagin = (*a).imagin * (*b).real + (*a).real * (*b).imagin;
  return temp;
}

void mnozenie2(Zespolone *a, Zespolone *b) {
  (*b).real = (*a).real * (*b).real - (*a).imagin - (*b).imagin;
  (*b).imagin = (*a).imagin * (*b).real + (*a).real * (*b).imagin;
}

Zespolone dzielenie(Zespolone *a, Zespolone *b) {
  Zespolone temp;
  
  temp.real = (*a).real * (*b).real + (*a).imagin * (*b).imagin;
  temp.imagin = (*a).imagin * (*b).real - (*a).real * (*b).imagin;
  temp.mianownik_dzielenia = (*b).real*(*b).real + (*b).imagin*(*b).imagin;
  return temp;
}

void dzielenie2(Zespolone *a, Zespolone *b) {
  (*b).real = (*a).real * (*b).real + (*a).imagin - (*b).imagin;
  (*b).imagin = (*a).imagin * (*b).real - (*a).real * (*b).imagin;
  (*b).mianownik_dzielenia = (*b).real*(*b).real + (*b).imagin*(*b).imagin;
}

#endif