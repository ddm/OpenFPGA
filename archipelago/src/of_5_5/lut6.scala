package fpga_components

import Chisel._
import Node._
import LutConstants._

// This is a 6-input lut with one output and one ff
class lut6 extends Component {
  val io = new Bundle {
    val lut_in = Bits(INPUT, 6)
    val lut_out = Bits(OUTPUT, 1)
    val lut_configs = Bits(INPUT, 64)
    val mux_configs = Bits(INPUT, 1)
    val ff_en = Bool(INPUT)
  }

  val lut6_o = io.lut_configs(io.lut_in)

  // declare one posedge flip-flops
  val ff1 = Reg(resetVal = Bits("b0", 1))
  
  // ff_en is disabled while programming
  when (io.ff_en) {
    ff1 := lut6_o
  }

  io.lut_out := Cat(ff1, lut6_o)(io.mux_configs(0))
}