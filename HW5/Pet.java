

public class Pet  {
	
		public String call()
		{ 
			return "!!!";
		}
		public String feet()
		{ 
			return "four";
		}
		
		public static void main(String[] args){

						 
		}
	 
}


class Dog extends Pet
{
  public String call()
  { 
    return "woof!";
  }
  public String toString()
  { 
    return "I'm a dog, pet me!";
  }
  public String call(int k)
  { 
    String s = "Woof";
    for(int i = 1; i < k; ++i)
      s += ", woof";
    return s + "!";
  }
}

class Cat extends Pet
{
  public String call()
  { 
    return "meow!";
  }
  public String toString()
  { 
    return "I'm a cat, go away!";
  }
  public String toString(String b)
  { 
    return b + "? ... " +
    "Don't waste my time.";
  }
}
