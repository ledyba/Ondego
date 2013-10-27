package org.ledyba.monad.io.net

import org.jsoup.Jsoup
import net.liftweb.common.Box
import net.liftweb.common.Failure
import org.jsoup.nodes.Document



object Html{
	def parse( src : String ) : Box[Document] = {
		try {
			return Box(Jsoup.parse(src));
		} catch {
			case x:Throwable => return Failure(x.toString());
		}
	}
}