package solid;
// interface segregation principle  

class Document {

}

// We should not put interface more then a class is expected to implements 
interface Machine {
	public void print(Document doc);

	public void scan(Document doc);

	public void fax(Document doc);

}

// This is wrong 
// YAGNI = you ain't going to need it 
class MultiPurposeMachine implements Machine {

	@Override
	public void print(Document doc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scan(Document doc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fax(Document doc) {
		// TODO Auto-generated method stub
	}

}

interface Printer {
	public void print(Document d);
}

interface Scaner {
	public void scan(Document d);
}

interface Fax {
	public void fax(Document d);
}

interface IMultiFunctionDevice extends Printer, Scaner {
}

// This is right 
// we should absoulte minimum in interface
class MultiFunctionMachine implements IMultiFunctionDevice {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub

	}

}

public class ISP {

}
