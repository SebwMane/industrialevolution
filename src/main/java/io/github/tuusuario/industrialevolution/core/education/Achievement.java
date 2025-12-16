package io.github.tuusuario.industrialevolution.core.education;

import java.util.List;

/**
 * Logros educativos desbloqueables con recompensas y dificultad.
 */
public class Achievement {
    private final String id;
    private final String name;
    private final String description;
    private final Difficulty difficulty;
    private final List<Reward> rewards;
    private boolean unlocked;

    public Achievement(String id, String name, String description, Difficulty difficulty, List<Reward> rewards) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.rewards = rewards;
        this.unlocked = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unlock() {
        this.unlocked = true;
        // Logic to award rewards would typically be handled by an AchievementManager
    }

    /**
     * Define la dificultad de un logro.
     */
    public enum Difficulty {
        EASY(1.0),
        MEDIUM(1.5),
        HARD(2.0),
        EPIC(3.0),
        LEGENDARY(5.0);

        private final double rewardMultiplier;

        Difficulty(double rewardMultiplier) {
            this.rewardMultiplier = rewardMultiplier;
        }

        public double getRewardMultiplier() {
            return rewardMultiplier;
        }
    }

    /**
     * Interfaz para definir una recompensa genérica.
     */
    public interface Reward {
        void awardToPlayer(Object player); // 'Object player' would be a specific Player class in a Minecraft context
        double getBaseValue(); // Valor base para el balanceo
        RewardType getType();
    }

    /**
     * Tipos de recompensa para categorización y balanceo.
     */
    public enum RewardType {
        ITEM, EXPERIENCE, CURRENCY, SPECIAL_ABILITY, COSMETIC
    }

    /**
     * Implementación de ejemplo para una recompensa de ítem.
     */
    public static class ItemReward implements Reward {
        private final String itemId; // Representa el ID del ítem en Minecraft
        private final int amount;
        private final double baseValue; // Valor base del ítem para balanceo

        public ItemReward(String itemId, int amount, double baseValue) {
            this.itemId = itemId;
            this.amount = amount;
            this.baseValue = baseValue;
        }

        @Override
        public void awardToPlayer(Object player) {
            // Lógica para dar el ítem al jugador en Minecraft
            System.out.println("Awarded " + amount + " of " + itemId + " to player " + player);
        }

        @Override
        public double getBaseValue() {
            return baseValue * amount;
        }

        @Override
        public RewardType getType() {
            return RewardType.ITEM;
        }

        public String getItemId() {
            return itemId;
        }

        public int getAmount() {
            return amount;
        }
    }

    // Otros tipos de recompensas (ExperienceReward, CurrencyReward, etc.) se definirían de manera similar.
}
