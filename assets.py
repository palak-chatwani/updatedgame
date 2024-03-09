from os.path import join as pj
from os import getcwd

from SimpleGUICS2Pygame.simpleguics2pygame import (
    _load_local_image as get_image,
)


"""
# Pathfinder
Defines the paths for various assets
"""

IMAGE_PATH = getcwd() + '/assets/images/'
ANIMATION_PATH = getcwd() + 'assets/animations/'
AUDIO_PATH = getcwd() + 'assets/audio/'
FONT_PATH = getcwd() + 'assets/fonts/'

# Bullet stuff
BULLET_IMG = get_image(pj(IMAGE_PATH, 'bullet.png'))

# Player stuff
PLAYER_IMG = get_image(pj(IMAGE_PATH, 'player.png'))

# Zombie stuff
ZOMBIE_IMG = get_image(pj(IMAGE_PATH, 'enemy-1.png'))



# Background stuff

# Barn / farm / base stuff
BARN_IMG = get_image(pj(IMAGE_PATH, 'farmhouse.jpg'))

ENDGAME_IMG = get_image(pj(IMAGE_PATH, 'gameover.png'))

# Sound stuff

# GUI stuff
