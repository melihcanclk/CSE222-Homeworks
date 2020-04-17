all: Q2 Q3

Q2: src_q2/Main.java src_q2/CustomDeque.java src_q2/CustomNotImplementedException.java src_q2/LinkedList.java
	@javac -cp Q2 src_q2/Main.java src_q2/CustomDeque.java src_q2/CustomNotImplementedException.java src_q2/LinkedList.java
	$(info Q2 Has Built, run "make runq2" to run Q2)

Q3: src_q3/Main.java src_q3/DetermineElfishWord.java src_q3/ExpressionRecursive.java src_q3/Print2DArray.java src_q3/RecursiveSelectionSort.java src_q3/ReverseString.java
	@javac -cp Q3 src_q3/Main.java src_q3/DetermineElfishWord.java src_q3/ExpressionRecursive.java src_q3/Print2DArray.java src_q3/RecursiveSelectionSort.java src_q3/ReverseString.java
	$(info Q3 Has Built, run "make runq3" to run Q3)

runq2:
	$(info Running Q2...)
	@java -classpath ./src_q2/ Main

runq3:
	$(info Running Q3...)
	@java -classpath ./src_q3/ Main

clean:
	$(info Cleaned All Build Files.)
	@rm -f *.class src_q2/*.class src_q3/*.class
