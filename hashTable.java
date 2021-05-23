import java.util.Objects;

import java.util.ArrayList;

import java.util.*;

 
public class hashTable
{
  
public static void main (String[]args)
  {
    
Scanner sc = new Scanner (System.in);
    
HashTable < String, Double > Table = new HashTable <> ();
    
Table.add ("hello", 1.2);
    
Table.add ("world", 3.14);
    
Table.add ("what", 933.0);
    
sc.close ();

} 
} 
 
class HashTable < K, V >

{
  
private ArrayList < Vertex < K, V >> Array;
  
private int buckies;
  
private int SIZE;
  
 
public HashTable ()
  {
    
SIZE = 0;
    
buckies = 77;
    
Array = new ArrayList <> ();
    
for (int i = 0; i < buckies; ++i)
      {
	
Array.add (null);
  
} 
} 
 
private final int hashCode (K key)
  {
    
return Objects.hashCode (key);
  
}
  
 
public V get (K key)
  {
    
int index = GET_INDEX (key);
    
int hashCode = hashCode (key);
    
Vertex < K, V > cur = Array.get (index);
    
while (cur != null)
      {
	
if (cur.key.equals (key) && cur.hashCode == hashCode)
	  return cur.value;
	
cur = cur.next;
      
}
    
return null;
  
}
  
 
private int GET_INDEX (K key)
  {
    
int hashCode = hashCode (key);
    
int index = hashCode % buckies;
    
if (index < 0)
      index *= -1;
    
return index;
  
}
  
 
public void add (K key, V value)
  {
    
int index = GET_INDEX (key);
    
int hashCode = hashCode (key);
    
Vertex < K, V > cur = Array.get (index);
    
while (cur != null)
      {
	
if (cur.key.equals (key) && cur.hashCode == hashCode)
	  {
	    
cur.value = value;
	    
return;
	  
}
	
cur = cur.next;
      
}
    
SIZE++;
    
cur = Array.get (index);
    
Vertex < K, V > newNode = new Vertex < K, V > (key, value, hashCode);
    
newNode.next = cur;
    
Array.set (index, newNode);
    
if (1.0 * SIZE >= 0.5 * buckies)
      {
	
ArrayList < Vertex < K, V >> old = Array;
	
Array = new ArrayList <> ();
	
buckies = 2 * buckies;
	
SIZE = 0;
	
for (int i = 0; i < buckies; ++i)
	  Array.add (null);
      
for (Vertex < K, V > x:old)
	  {
	    
while (x != null)
	      {
		add (x.key, x.value);
		x = x.next;
	      
}
	  
}
      
}
  
}
  
 
class Vertex < K, V >
  {
    
K key;
    
V value;
    
final int hashCode;
    
Vertex < K, V > next;
    
 
public Vertex (K newKey, V newValue, int newHashCode)
    {
      
this.key = newKey;
      
this.value = newValue;
      
this.hashCode = newHashCode;

} 
} 
} 
 
