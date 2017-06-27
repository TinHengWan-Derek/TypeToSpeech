TypeToSpeech by Tin Heng Wan (Derek) using Python

This program was created using Java long time ago,
but the library is not working any more.
This is why I program this in Python again.
Turn out it is very easy using Python.

Intention:

    I know lots of people with learning disabilities who feel unsupported by the society and education system.
    For example, people with learning disabilities such as dyslexia (difficulty in reading)
    and dysgraphia (inability to write coherently) is really hard to learn and to survive
    in the standardized education system.
    I believe text-to-speech (TTS) technology can help them.

Problem:

    Nowadays, people with learning disabilities often using computer as an aid to
    type essay and use text-to-speech technology to proofread their essay.
    However, this may use up lots of time when they are copying a section of text.

    Another problem is that typo is really hard to catch while the typing process.
    Use TTS to translate and check for typo/mistake often takes lots of time too.

Solution:

    My solution is to provide a input text field which have a buffer underneath
    that save the current word. When the user press space (go to the next word),
    it will pronoun the previous word.

Start the program:
```
python TypeToSpeech.py
```
