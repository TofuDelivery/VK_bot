package main.com.company.java;

public class Character
{
    String name;
    int maximumHealth;
    int currentHealth;
    int damage;

    public Character(String name, int health, int damage)
    {
        this.name = name;
        this.maximumHealth = health;
        this.currentHealth = this.maximumHealth;
        this.damage = damage;
    }

    public boolean IsAlive()
    {
        return this.currentHealth > 0;
    }

    private void DealDamage(Character enemy)
    {
        enemy.currentHealth -= this.damage;
    }

    private void ReceiveDamage(Character enemy)
    {
        this.currentHealth -= enemy.damage;
    }

    private void RestoreHealth()
    {
        this.currentHealth = this.maximumHealth;
    }

    public void Fight(Character enemy)
    {
        while(this.IsAlive() && enemy.IsAlive())
        {
            this.DealDamage(enemy);
            if (enemy.IsAlive())
                this.ReceiveDamage(enemy);
        }
        if (this.IsAlive())
        {
            System.out.println("You won! Your current health is " + currentHealth);
            enemy.RestoreHealth();
        }
        else
            System.out.println("You lose!");
    }

    private void ChangeName(String name)
    {
        this.name = name;
    }

    private void ChangeMaximumHealth(int health)
    {
        this.maximumHealth = health;
        this.currentHealth = health;
    }

    private void ChangeDamage(int damage)
    {
        this.damage = damage;
    }

    public void ChangeCharacter(Character anotherCharacter)
    {
        ChangeName(anotherCharacter.name);
        ChangeMaximumHealth(anotherCharacter.maximumHealth);
        ChangeDamage(anotherCharacter.damage);
    }
}
