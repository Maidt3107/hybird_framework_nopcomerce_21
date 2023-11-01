package javaOOP.abstraction;

public class Dog implements IAnimal,ICity{
	//không mang ra để sử dụng  được luôn
	//phải viết lại mới dùng được
	//khác knowlege của kế thừa(extends)

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

}
