package CorbaApp;

/**
* CorbaApp/ValuesGetterHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ValuesGetter.idl
* Thursday, 13 April 2017 21:01:19 o'clock GMT+03:00
*/

public final class ValuesGetterHolder implements org.omg.CORBA.portable.Streamable
{
  public CorbaApp.ValuesGetter value = null;

  public ValuesGetterHolder ()
  {
  }

  public ValuesGetterHolder (CorbaApp.ValuesGetter initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CorbaApp.ValuesGetterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CorbaApp.ValuesGetterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CorbaApp.ValuesGetterHelper.type ();
  }

}
