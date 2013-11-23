package org.ledyba.functional;

import java.util.ArrayList;
import java.util.Collection;

public class List<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;

	public List() {
	}

	public List(int capacity) {
		super(capacity);
	}

	public List(Collection<? extends E> collection) {
		super(collection);
	}
	
	public <R> List<R> fmap( Func<E, R> f ) {
		List<R> r = new List<R>();
		for( E e : this ) {
			r.add(f.apply(e));
		}
		return r;
	}
	
	public E first(){
		return get(0);
	}

	public E last(){
		return get( size() - 1 );
	}
	
	public List<E> filter( Func<E, Boolean> f ) {
		List<E> r = new List<E>();
		for( E e : this ) {
			if(f.apply(e)) r.add(e);
		}
		return r;
	}
	public List<E> filterNot( Func<E, Boolean> f ) {
		List<E> r = new List<E>();
		for( E e : this ) {
			if(!f.apply(e)) r.add(e);
		}
		return r;
	}

	public <R> List<R> flatMap( Func<E, List<R> > f ) {
		List<R> r = new List<R>();
		for( E e : this ) {
			r.addAll(f.apply(e));
		}
		return r;
	}
	
	public List<E> foreach(Func<E, ?> f) {
		for( E e : this ) {
			f.apply(e);
		}
		return this;
	}
}
