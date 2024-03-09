import SimpleGUICS2Pygame.simpleguics2pygame as simplegui
from assets import BARN_IMG

# Constants for window size
WIDTH = 800
HEIGHT = 600

class Barn:
    def __init__(self):
        self.image = BARN_IMG
        self.x = WIDTH / 2
        self.y = 700  # Adjust the barn's position to be at the bottom of the screen
        self.width = 800  # Adjust width and height for a better display
        self.height = 200

    def draw(self, canvas):
        canvas.draw_image(
            self.image,
            (self.image.get_width() / 2, self.image.get_height() / 2),
            (self.image.get_width(), self.image.get_height()),
            (self.x, self.y),
            (self.width, self.height),
        )




