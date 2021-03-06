
package acme.entities.accountingRecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountingRecord extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String					title;

	@NotNull
	private accountingRecordStatus	status;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date					moment;

	@NotBlank
	private String					body;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private InvestmentRound			investmentRound;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Bookkeeper				creator;

}
