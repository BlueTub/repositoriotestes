package br.sceweb.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class Convenio {

	private String cnpj;

	private DateTime dataInicio;

	private DateTime dataTerminino;

	Logger logger = Logger.getLogger(Convenio.class);

	/**
	 * valida o formato da data
	 * 
	 * @param data
	 *            no formato dd/MM/yyyy
	 * @return true se a data estiver no formato valido e false para formato
	 *         invalido
	 */
	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			logger.error("Erro na validacao de data - " + ex.getMessage());
			return false;
		}

	}

	/**
	* valida a data de inicio
	* @param dataInicio - data do inicio da vigencia de um convenio
	* @throws IllegalArgumentException
	*/
	
	public void setDataInicio(String dataInicio)
			throws IllegalArgumentException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>data inicio = " + dataInicio);
		if (validaData(dataInicio)) {
			this.dataInicio = new DateTime(Integer.parseInt(dataInicio
					.substring(6, 10)), Integer.parseInt(dataInicio.substring(
					3, 5)), Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
		} else {
			throw new IllegalArgumentException("data invalida");
		}
	}

	public String getCNPJ() {
		return cnpj;
	}

	public DateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(DateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	

}
