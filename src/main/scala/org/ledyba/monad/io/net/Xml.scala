package org.ledyba.monad.io.net

import org.jsoup.Jsoup
import net.liftweb.common.Box
import net.liftweb.common.Failure
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

object Xml {
	def parse( src : String ) : Box[Document] = {
		try {
			return Box(Jsoup.parse(src, "", Parser.xmlParser()));
		} catch {
			case x:Throwable => return Failure(x.toString());
		}
	}
}