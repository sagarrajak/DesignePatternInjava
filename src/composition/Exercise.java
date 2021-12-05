package composition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

interface ValueContainer extends Iterable<Integer> {
    public int sum();
}

class SingleValue implements ValueContainer
{
   public int value;

   // please leave this constructor as-is
      public SingleValue(int value)
      {
        this.value = value;
      }
    @Override
    public int sum() {
        return this.value;
    }
    
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return Collections.singleton(this.value).iterator();
	}
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
    @Override
    public int sum() {
        int sum = 0;
        for (Integer val: this) {
            sum += val;
        }
        return sum;
    }

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}


class MyList extends ArrayList<ValueContainer> 
{
    // please leave this constructor as-is
  public MyList(Collection<? extends ValueContainer> c)
  {
    super(c);
  }

  public int sum()
  {
      int sum = 0;
      for (ValueContainer current: this)
        {
            sum += current.sum();
        }
        return sum;
  }
}

