package demo.ref.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InstrumentMapping {

  private final String originalInstrumentCd;
  private final String updatedInstrumentCd;
}
