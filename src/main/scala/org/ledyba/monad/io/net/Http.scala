package org.ledyba.monad.io.net

import java.net.URL
import scala.io.Source

object Http {
	def get( url : String, enc : String ="utf8" ) : Http = {
		return Http(url, enc);
	}
}

sealed case class Http(val url_ : String, val enc_ : String) {
	def read() : Option[String] = {
		val url = new URL(url_);
		val s = Source.fromURL(url, enc_);
		try {
			return Some(s.mkString);
		} finally {
			s.close();
		}
		return None;
	}
	def read(times:Int) : Option[String] = {
		for(i <- 1 to times){
			val r = read
			if(r.isDefined){
				return r;
			}
		}
		return None;
	}
}