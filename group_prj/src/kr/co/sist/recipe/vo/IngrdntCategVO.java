package kr.co.sist.recipe.vo;

<<<<<<< HEAD



/**
 * @author 05-25:ȫ��ȯ
 *	IngrdntSchVO���� �� IngrdntCategVO�� ����
 * ������ �߰�â���� ��Ḧ �˻��Ҷ� ������ ������ ����� ������ ������ ��ᰡ ��ȸ�Ǳ� ������
 *
 */
=======
>>>>>>> refs/heads/hong
public class IngrdntCategVO {
	private String brand,ingrdntSort;
	
	public IngrdntCategVO(){
		
	}
	public IngrdntCategVO(String brand,String ingrdntSort){
		super();
		this.brand=brand;
		this.ingrdntSort=ingrdntSort;
	}
	public String getBrand() {
		return brand;
	}
	public String getIngrdntSort() {
		return ingrdntSort;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setIngrdntSort(String ingrdntSort) {
		this.ingrdntSort = ingrdntSort;
	}
	@Override
	public String toString() {
		return "IngrdntCategVO [brand=" + brand + ", ingrdntSort=" + ingrdntSort + "]";
	}
	
}
