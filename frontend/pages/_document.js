import { Html, Head, Main, NextScript } from 'next/document'

import Header from "/src/component/Header";
import Nav from "/src/component/Nav";

export default function Document() {
  return (
    <Html lang="en">
      <Head />
      <body>
          <Header/>
          <Nav/>
          <Main />
          <NextScript />
      </body>
    </Html>
  )
}
