#include "SDL.h"   /* All SDL App's need this */
#include <stdio.h>

int main(int argc, char *argv[]) {
    
    SDL_Surface *screen;

    printf("Initializing SDL.\n");
    
    /* Initialize defaults */
    if((SDL_Init(SDL_INIT_VIDEO)<-1)) { 
        printf("Could not initialize SDL: %s.\n", SDL_GetError());
        exit(-1);
    }


    printf("SDL initialized.\n");


    screen = SDL_SetVideoMode(640, 480, 8, SDL_SWSURFACE);
    if ( screen == NULL ) {
        fprintf(stderr, "Couldn't set 640x480x8 video mode: %s\n",
                        SDL_GetError());

	}



    printf("Quiting SDL.\n");
    
    /* Shutdown all subsystems */
    SDL_Quit();
    
    printf("Quiting....\n");	

    exit(0);
}

