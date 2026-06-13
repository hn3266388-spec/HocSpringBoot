package Study.spring.boot.DI_IOC;

import org.springframework.stereotype.Component;

@Component
public class Topho {
	// private final ThitBo thitbo;
	private final BanhPho banhpho;
	// Giao toàn quyeenftajo đối tượng bằng 1 bên thứ 3 => Spring Conteiner ( Quản
	// lý bean)
	// muốn chuyển giao đối tượng dùng DI (thêm phụ thuộc)
	// public Topho(ThitBo thitbo, BanhPho banhpho) {
	// this.thitbo = thitbo;
	// this.banhpho = banhpho;
	// }
	private final CacLoaiThit thit;

	public Topho(BanhPho banhpho, CacLoaiThit thit) {
		super();
		this.banhpho = banhpho;
		this.thit = thit;
	}

	public void phucvu() {
		System.out.println("Lấy bát "+banhpho.LayPho()+" "+thit.LayThit());
	}
}
