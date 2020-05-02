all: Q1 Q2 Q3 Q4

Q1: src_q1/Main.java src_q1/FileSystemTree.java src_q1/NodeInterface.java src_q1/ReverseString.java
	@javac -cp Q1 src_q1/Main.java src_q1/FileSystemTree.java src_q1/NodeInterface.java src_q1/ReverseString.java
	$(info Q1 Has Built, run "make runq1" to run Q1)

Q2: src_q2/Main.java src_q2/BinaryTree.java src_q2/ExpressionTree.java
	@javac -cp Q2 src_q2/Main.java src_q2/BinaryTree.java src_q2/ExpressionTree.java
	$(info Q2 Has Built, run "make runq2" to run Q2)

Q3: src_q3/Main.java src_q3/AgeData.java src_q3/AgeSearchTree.java src_q3/BinarySearchTree.java src_q3/BinaryTree.java src_q3/SearchTree.java
	@javac -cp Q3 src_q3/Main.java src_q3/AgeData.java src_q3/AgeSearchTree.java src_q3/BinarySearchTree.java src_q3/BinaryTree.java src_q3/SearchTree.java
	$(info Q3 Has Built, run "make runq3" to run Q3)

Q4: src_q4/Main.java src_q4/AgeData.java src_q4/CustomComperator.java src_q4/MaxHeap.java 
	@javac -cp Q4 src_q4/Main.java src_q4/AgeData.java src_q4/CustomComperator.java src_q4/MaxHeap.java 
	$(info Q4 Has Built, run "make runq4" to run Q4)

runq1:
	$(info Running Q1...)
	@java -classpath ./src_q1/ Main

runq2:
	$(info Running Q2...)
	@java -classpath ./src_q2/ Main

runq3:
	$(info Running Q3...)
	@java -classpath ./src_q3/ Main

runq4:
	$(info Running Q4...)
	@java -classpath ./src_q4/ Main

clean:
	$(info Cleaned All Build Files.)
	@rm -f *.class src_q1/*.class src_q2/*.class src_q3/*.class src_q4/*.class
