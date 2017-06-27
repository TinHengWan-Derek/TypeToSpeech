import os
from Tkinter import *

currentWord = ""

def toSpeech(word):
    os.system("say '"+ word + "'")

def addCharToBuffer(char):
    global currentWord
    currentWord += char

def removeCharFromBuffer():
    global currentWord
    currentWord = currentWord[0:-1]

def main():

    space = " "
    enter = "'\\r'"
    root = Tk()
    root.title("TypeToSpeech by Derek !")

    def key(event):
        global currentWord
        if event.char == space or repr(event.char) == enter :
            toSpeech(currentWord)
            currentWord = ""
        else:
            addCharToBuffer(event.char)

    T = Text(root, height=20, width=80)
    T.bind("<Key>", key)
    T.pack()

    mainloop()

if __name__ == '__main__':
    main()
