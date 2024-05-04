package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	
	    JUJUY(800000, 53219), 
	    SALTA(1300000, 155488), 
	    TUCUMAN(1670000, 22524), 
	    CATAMARCA(380000, 102602), 
	    LA_RIOJA(390000, 89680),
	    SANTIAGO_DEL_ESTERO(875000, 136351); 

	    private int cantPobl;
	    private int sup;

	   
		private Provincia(int cantPobl, int sup) {
			this.cantPobl = cantPobl;
			this.sup = sup;
		}

		public int getCantPobl() {
			return cantPobl;
		}

		public void setCantPobl(int cantPobl) {
			this.cantPobl = cantPobl;
		}

		public int getSup() {
			return sup;
		}

		public void setSup(int sup) {
			this.sup = sup;
		}


		public double CalcularDensidad() {
	        return (double) cantPobl / sup;
	    }
	}
