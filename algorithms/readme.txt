Michael Church, Pan Huang, Zhaochong Liu, Ruichen Dai, Sidi Liu

We updated union, minus, project, compatable, evalTup, extracTup,infix2postfix,typeCheck methods.
We then used MovieDB to run and check our code.

In MovieDB we had to change one of the types in the movieExec table from Float to Double
In MovieDB we also removed the single quotes in movie.select("title == 'Star Wars'")

To compile:
javac Table.java MovieDB.java

To run:
java MovieDB