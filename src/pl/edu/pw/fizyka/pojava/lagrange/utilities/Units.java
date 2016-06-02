package pl.edu.pw.fizyka.pojava.lagrange.utilities;

public enum Units {
	PICO {
		@Override
		public double getDecimal() {
			return Math.pow(10, -12);
		}

		@Override
		public String toString() {
			return "Pico";
		}
	},
	NANO {
		@Override
		public double getDecimal() {
			return Math.pow(10, -9);
		}

		@Override
		public String toString() {
			return "Nano";
		}
	},
	MICRO {

		@Override
		public double getDecimal() {
			return Math.pow(10, -6);
		}

		@Override
		public String toString() {
			return "Micro";
		}
  
	},
	MILLI {
		@Override
		public double getDecimal() {
			return Math.pow(10, -3);
		}

		@Override
		public String toString() {
			return "Milli";
		}
	};
	
	
	public abstract double getDecimal();
	public abstract String toString();
}


