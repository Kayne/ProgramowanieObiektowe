#ifndef ZAD2
#define ZAD2
#include <stdio.h>

enum typfig {PUNKT, KOLO, KWADRAT};

typedef struct Figura 
{ 
    enum typfig typ;
    float x;
    float y;
    int promien; // dla koła
    float x2; // x kwadratu
    float y2; // y kwadratu
} Figura;

void narysuj(Figura *f) {
  if ((*f).typ == PUNKT) {
    printf("Punkt leży na x: %f i y: %f", (*f).x, (*f).y);
  } else if ((*f).typ == KOLO) {
    printf("Koło ma środek w x: %f i y: %f i promień: %d", (*f).x, (*f).y, (*f).promien);
  } else if ((*f).typ == KWADRAT) {
    printf("Kwadrat zaczyna się w: %f i y: %f i kończy w  x2: %f, y2: %f", (*f).x, (*f).y, (*f).x2, (*f).y2);
  }
  printf("\n");
}

void przesun(Figura *f, float x, float y) {
  if ((*f).typ == PUNKT) {
    (*f).x += x;
    (*f).y += y;
  } else if ((*f).typ == KOLO) {
    (*f).x += x;
    (*f).y += y;
  } else if ((*f).typ == KWADRAT) {
    (*f).x += x;
    (*f).y += y;
    (*f).x2 += x;
    (*f).y2 += y;
  }
}

int zawiera(Figura *f, float x, float y) {
  if ((*f).typ == PUNKT) {
    if ((*f).x == x && (*f).y == y) {
      return 1;
    }
  } else if ((*f).typ == KOLO) {
    if ((x*x-(*f).x) + (y*y-(*f).y) <= (*f).promien*(*f).promien) {
      return 1;
    }
  } else if ((*f).typ == KWADRAT) {
    if (x >= (*f).x && x <= (*f).x2) {
      if (y >= (*f).y && y <= (*f).y2) {
        return 1;
      }
    }
  }
  return 0;
}

void stworzpunkt(Figura *f, float x, float y) {
  (*f).typ = PUNKT;
  (*f).x = x;
  (*f).y = y;
}

void stworzkolo(Figura *f, float x, float y, int promien) {
  (*f).typ = KOLO;
  (*f).x = x;
  (*f).y = y;
  (*f).promien = promien;
}

void stworzkwadrat(Figura *f, float x, float y, float x2, float y2) {
  (*f).typ = KWADRAT;
  (*f).x = 21;
  (*f).y = 10;
  (*f).x2 = 41;
  (*f).y2 = 20;
}

#endif