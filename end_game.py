import SimpleGUICS2Pygame.simpleguics2pygame as simplegui

# Constants for window size
WIDTH = 800
HEIGHT = 600

# Function to draw the end game screen
def draw(canvas):
    # Draw "You Died" message
    canvas.draw_text("You Died", (WIDTH / 2 - 60, HEIGHT / 2 - 20), 40, "Red")
    
    # Draw restart game button
    canvas.draw_polygon([(WIDTH / 2 - 50, HEIGHT / 2 + 20),
                         (WIDTH / 2 + 50, HEIGHT / 2 + 20),
                         (WIDTH / 2 + 50, HEIGHT / 2 + 60),
                         (WIDTH / 2 - 50, HEIGHT / 2 + 60)], 2, "Red", "Green")
    canvas.draw_text("Restart Game", (WIDTH / 2 - 70, HEIGHT / 2 + 45), 20, "Green")
    
    # Draw exit game button
    canvas.draw_polygon([(WIDTH / 2 - 50, HEIGHT / 2 + 80),
                         (WIDTH / 2 + 50, HEIGHT / 2 + 80),
                         (WIDTH / 2 + 50, HEIGHT / 2 + 120),
                         (WIDTH / 2 - 50, HEIGHT / 2 + 120)], 2, "Red", "Green")
    canvas.draw_text("Exit Game", (WIDTH / 2 - 45, HEIGHT / 2 + 105), 20, "Green")
    
    # Draw return to main menu button
    canvas.draw_polygon([(WIDTH / 2 - 90, HEIGHT / 2 + 140),
                         (WIDTH / 2 + 90, HEIGHT / 2 + 140),
                         (WIDTH / 2 + 90, HEIGHT / 2 + 180),
                         (WIDTH / 2 - 90, HEIGHT / 2 + 180)], 2, "Red", "Green")
    canvas.draw_text("Return to Main Menu", (WIDTH / 2 - 120, HEIGHT / 2 + 165), 20, "Green")

# Create a frame
frame = simplegui.create_frame("End Game Screen", WIDTH, HEIGHT)

# Set the draw handler
frame.set_draw_handler(draw)

# Start the frame
frame.start()
