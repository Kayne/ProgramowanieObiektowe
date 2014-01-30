#include "zad2.h"

int main() {
  Figura cos;
  stworzpunkt(&cos, 21, 10);
  narysuj(&cos);
  przesun(&cos, 5, 10);
  narysuj(&cos);

  if (zawiera(&cos, 26,20)) {
    printf("26,20 zawiera się w punkcie.");
  } else {
    printf("26,20 nie zawiera się w punkcie.");
  }
  printf("\n");
  if (zawiera(&cos, 27,20)) {
    printf("27,20 zawiera się w punkcie.");
  } else {
    printf("27,20 nie zawiera się w punkcie.");
  }
  printf("\n");

  stworzkolo(&cos, 21, 10, 50);
  narysuj(&cos);
  przesun(&cos, 5, 10);
  narysuj(&cos);

  if (zawiera(&cos, 30,22)) {
    printf("30,22 zawiera się w kole.");
  } else {
    printf("30,22 nie zawiera się w punkcie.");
  }
  printf("\n");
  if (zawiera(&cos, 9000,9000)) {
    printf("9000,9000 zawiera się w kole.");
  } else {
    printf("9000,9000 nie zawiera się w kole.");
  }
  printf("\n");

  stworzkwadrat(&cos, 21, 10, 21, 20);
  narysuj(&cos);
  przesun(&cos, 5, 10);
  narysuj(&cos);

  if (zawiera(&cos, 30,22)) {
    printf("30,22 zawiera się w kwadracie.");
  } else {
    printf("30,22 nie zawiera się w kwadracie.");
  }
  printf("\n");
  if (zawiera(&cos, 9000,9000)) {
    printf("9000,9000 zawiera się w kwadracie.");
  } else {
    printf("9000,9000 nie zawiera się w kwadracie.");
  }
  printf("\n");

  printf("\n");
  return 0;
}