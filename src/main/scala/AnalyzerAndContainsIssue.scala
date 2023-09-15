import scala.language.implicitConversions

/**
 * This test breaks Analyzer - Syntax analysis would never(?) complete
 */
private class AnalyzerAndContainsIssue {

  /**
   *   Expected an issue (No implicit arguments of type: Contains[F, Int]), got _very_ slow analyzer.
   */
  def testIssue[F](arr: Array[TestClass[F]]): Unit = {
    arr.map(issue(_))
  }

  // Int here should be irrelevant - just used as an example
  private def issue[F](in: TestClass[F])(implicit ev: F Contains Int, ev2: F Contains String): Any = {}

  class TestClass[T]()
}

trait Contains[F, T] {
}

trait ContainsAndDrops[F, T] extends Contains[F, T] {
}

object Contains {
  type UpdateAux[F, T, X, FOut] = Contains[F, T] { }

  implicit def THasX[T <: X, X, XX]: UpdateAux[T, X, XX, XX] = new Contains[T, X] {}

  type UpdateAuxWithDrop[F, T, X, FOut, WOut] = ContainsAndDrops[F, T] { }

  implicit def Tuple2Has1[T1 <: X, T2, X, XX]: UpdateAuxWithDrop[(T1, T2), X, XX, (XX, T2), T2] = new ContainsAndDrops[(T1, T2), X] {}

  implicit def Tuple2Has2[T1, T2 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2), X, XX, (T1, XX), T1] = new ContainsAndDrops[(T1, T2), X] {}

  implicit def Tuple3Has1[T1 <: X, T2, T3, X, XX]: UpdateAuxWithDrop[(T1, T2, T3), X, XX, (XX, T2, T3), (T2, T3)] = new ContainsAndDrops[(T1, T2, T3), X] {}

  implicit def Tuple3Has2[T1, T2 <: X, T3, X, XX]: UpdateAuxWithDrop[(T1, T2, T3), X, XX, (T1, XX, T3), (T1, T3)] = new ContainsAndDrops[(T1, T2, T3), X] {}

  implicit def Tuple3Has3[T1, T2, T3 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3), X, XX, (T1, T2, XX), (T1, T2)] = new ContainsAndDrops[(T1, T2, T3), X] {}

  implicit def Tuple4Has1[T1 <: X, T2, T3, T4, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4), X, XX, (XX, T2, T3, T4), (T2, T3, T4)] = new ContainsAndDrops[(T1, T2, T3, T4), X] {}

  implicit def Tuple4Has2[T1, T2 <: X, T3, T4, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4), X, XX, (T1, XX, T3, T4), (T1, T3, T4)] = new ContainsAndDrops[(T1, T2, T3, T4), X] {}

  implicit def Tuple4Has3[T1, T2, T3 <: X, T4, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4), X, XX, (T1, T2, XX, T4), (T1, T2, T4)] = new ContainsAndDrops[(T1, T2, T3, T4), X] {}

  implicit def Tuple4Has4[T1, T2, T3, T4 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4), X, XX, (T1, T2, T3, XX), (T1, T2, T3)] = new ContainsAndDrops[(T1, T2, T3, T4), X] {}

  implicit def Tuple5Has1[T1 <: X, T2, T3, T4, T5, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5), X, XX, (XX, T2, T3, T4, T5), (T2, T3, T4, T5)] = new ContainsAndDrops[(T1, T2, T3, T4, T5), X] {}

  implicit def Tuple5Has2[T1, T2 <: X, T3, T4, T5, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5), X, XX, (T1, XX, T3, T4, T5), (T1, T3, T4, T5)] = new ContainsAndDrops[(T1, T2, T3, T4, T5), X] {}

  implicit def Tuple5Has3[T1, T2, T3 <: X, T4, T5, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5), X, XX, (T1, T2, XX, T4, T5), (T1, T2, T4, T5)] = new ContainsAndDrops[(T1, T2, T3, T4, T5), X] {}

  implicit def Tuple5Has4[T1, T2, T3, T4 <: X, T5, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5), X, XX, (T1, T2, T3, XX, T5), (T1, T2, T3, T5)] = new ContainsAndDrops[(T1, T2, T3, T4, T5), X] {}

  implicit def Tuple5Has5[T1, T2, T3, T4, T5 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5), X, XX, (T1, T2, T3, T4, XX), (T1, T2, T3, T4)] = new ContainsAndDrops[(T1, T2, T3, T4, T5), X] {}

  implicit def Tuple6Has1[T1 <: X, T2, T3, T4, T5, T6, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (XX, T2, T3, T4, T5, T6), (T2, T3, T4, T5, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple6Has2[T1, T2 <: X, T3, T4, T5, T6, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (T1, XX, T3, T4, T5, T6), (T1, T3, T4, T5, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple6Has3[T1, T2, T3 <: X, T4, T5, T6, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (T1, T2, XX, T4, T5, T6), (T1, T2, T4, T5, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple6Has4[T1, T2, T3, T4 <: X, T5, T6, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (T1, T2, T3, XX, T5, T6), (T1, T2, T3, T5, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple6Has5[T1, T2, T3, T4, T5 <: X, T6, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (T1, T2, T3, T4, XX, T6), (T1, T2, T3, T4, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple6Has6[T1, T2, T3, T4, T5, T6 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6), X, XX, (T1, T2, T3, T4, T5, XX), (T1, T2, T3, T4, T5)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6), X] {}

  implicit def Tuple7Has1[T1 <: X, T2, T3, T4, T5, T6, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (XX, T2, T3, T4, T5, T6, T7), (T2, T3, T4, T5, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has2[T1, T2 <: X, T3, T4, T5, T6, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, XX, T3, T4, T5, T6, T7), (T1, T3, T4, T5, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has3[T1, T2, T3 <: X, T4, T5, T6, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, T2, XX, T4, T5, T6, T7), (T1, T2, T4, T5, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has4[T1, T2, T3, T4 <: X, T5, T6, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, T2, T3, XX, T5, T6, T7), (T1, T2, T3, T5, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has5[T1, T2, T3, T4, T5 <: X, T6, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, T2, T3, T4, XX, T6, T7), (T1, T2, T3, T4, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has6[T1, T2, T3, T4, T5, T6 <: X, T7, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, T2, T3, T4, T5, XX, T7), (T1, T2, T3, T4, T5, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple7Has7[T1, T2, T3, T4, T5, T6, T7 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7), X, XX, (T1, T2, T3, T4, T5, T6, XX), (T1, T2, T3, T4, T5, T6)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7), X] {}

  implicit def Tuple8Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8), (T2, T3, T4, T5, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8), (T1, T3, T4, T5, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8), (T1, T2, T4, T5, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8), (T1, T2, T3, T5, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8), (T1, T2, T3, T4, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8), (T1, T2, T3, T4, T5, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8), (T1, T2, T3, T4, T5, T6, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple8Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX), (T1, T2, T3, T4, T5, T6, T7)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8), X] {}

  implicit def Tuple9Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9), (T2, T3, T4, T5, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9), (T1, T3, T4, T5, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9), (T1, T2, T4, T5, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9), (T1, T2, T3, T5, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9), (T1, T2, T3, T4, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9), (T1, T2, T3, T4, T5, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9), (T1, T2, T3, T4, T5, T6, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9), (T1, T2, T3, T4, T5, T6, T7, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple9Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX), (T1, T2, T3, T4, T5, T6, T7, T8)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9), X] {}

  implicit def Tuple10Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9, T10), (T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9, T10), (T1, T3, T4, T5, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9, T10), (T1, T2, T4, T5, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9, T10), (T1, T2, T3, T5, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9, T10), (T1, T2, T3, T4, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9, T10), (T1, T2, T3, T4, T5, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9, T10), (T1, T2, T3, T4, T5, T6, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9, T10), (T1, T2, T3, T4, T5, T6, T7, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, T10, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX, T10), (T1, T2, T3, T4, T5, T6, T7, T8, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple10Has10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, XX), (T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), X] {}

  implicit def Tuple11Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), (T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9, T10, T11), (T1, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9, T10, T11), (T1, T2, T4, T5, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9, T10, T11), (T1, T2, T3, T5, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9, T10, T11), (T1, T2, T3, T4, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9, T10, T11), (T1, T2, T3, T4, T5, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9, T10, T11), (T1, T2, T3, T4, T5, T6, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9, T10, T11), (T1, T2, T3, T4, T5, T6, T7, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, T10, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX, T10, T11), (T1, T2, T3, T4, T5, T6, T7, T8, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 <: X, T11, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, XX, T11), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple11Has11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, XX), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), X] {}

  implicit def Tuple12Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), (T1, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9, T10, T11, T12), (T1, T2, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9, T10, T11, T12), (T1, T2, T3, T5, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9, T10, T11, T12), (T1, T2, T3, T4, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9, T10, T11, T12), (T1, T2, T3, T4, T5, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9, T10, T11, T12), (T1, T2, T3, T4, T5, T6, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9, T10, T11, T12), (T1, T2, T3, T4, T5, T6, T7, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, T10, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX, T10, T11, T12), (T1, T2, T3, T4, T5, T6, T7, T8, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 <: X, T11, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, XX, T11, T12), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 <: X, T12, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, XX, T12), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple12Has12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, XX), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), X] {}

  implicit def Tuple13Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (T1, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), (T1, T2, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9, T10, T11, T12, T13), (T1, T2, T3, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9, T10, T11, T12, T13), (T1, T2, T3, T4, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9, T10, T11, T12, T13), (T1, T2, T3, T4, T5, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9, T10, T11, T12, T13), (T1, T2, T3, T4, T5, T6, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9, T10, T11, T12, T13), (T1, T2, T3, T4, T5, T6, T7, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, T10, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX, T10, T11, T12, T13), (T1, T2, T3, T4, T5, T6, T7, T8, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 <: X, T11, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, XX, T11, T12, T13), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 <: X, T12, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, XX, T12, T13), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12 <: X, T13, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, XX, T13), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple13Has13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, XX), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), X] {}

  implicit def Tuple14Has1[T1 <: X, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (XX, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has2[T1, T2 <: X, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, XX, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (T1, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has3[T1, T2, T3 <: X, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, XX, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (T1, T2, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has4[T1, T2, T3, T4 <: X, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, XX, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), (T1, T2, T3, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has5[T1, T2, T3, T4, T5 <: X, T6, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, XX, T6, T7, T8, T9, T10, T11, T12, T13, T14), (T1, T2, T3, T4, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has6[T1, T2, T3, T4, T5, T6 <: X, T7, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, XX, T7, T8, T9, T10, T11, T12, T13, T14), (T1, T2, T3, T4, T5, T7, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has7[T1, T2, T3, T4, T5, T6, T7 <: X, T8, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, XX, T8, T9, T10, T11, T12, T13, T14), (T1, T2, T3, T4, T5, T6, T8, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has8[T1, T2, T3, T4, T5, T6, T7, T8 <: X, T9, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, XX, T9, T10, T11, T12, T13, T14), (T1, T2, T3, T4, T5, T6, T7, T9, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has9[T1, T2, T3, T4, T5, T6, T7, T8, T9 <: X, T10, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, XX, T10, T11, T12, T13, T14), (T1, T2, T3, T4, T5, T6, T7, T8, T10, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 <: X, T11, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, XX, T11, T12, T13, T14), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T11, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 <: X, T12, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, XX, T12, T13, T14), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T12, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12 <: X, T13, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, XX, T13, T14), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T13, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13 <: X, T14, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, XX, T14), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T14)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

  implicit def Tuple14Has14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14 <: X, X, XX]: UpdateAuxWithDrop[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X, XX, (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, XX), (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new ContainsAndDrops[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), X] {}

}