Language Action Pipeline Instruction System
=====
Lapis is a tool that converts text into actions, specified in json files.

Sentences like "Increase volume by 20 percent" are parsed into tokens which specify the
routine used ```(ROUTINE, "volume")``` and its parameters ```(PARAMETER, "20 percent")```. Those are
then passed on to whatever is specified in the action of the routine. 

This project uses the JSON classes from https://github.com/douglascrockford/JSON-java/
